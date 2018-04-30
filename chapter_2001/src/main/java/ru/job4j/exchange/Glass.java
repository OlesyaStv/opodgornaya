package ru.job4j.exchange;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.System;
import java.util.StringJoiner;

public class Glass {

    private static Integer book;
    private LinkedList<Request> bidLinkedList;
    private LinkedList<Request> askLinkedList;
    private LinkedList<PrintLine> printList;

    public Integer getPrintListSize() {
        return printList.size();
    }

    public LinkedList<Request> whatList(Request request) {
        LinkedList<Request> list = null;
        if (request.getAction() == "BID") {
            list = bidLinkedList;
        } else if (request.getAction() ==  "ASK") {
            list = askLinkedList;
        }
        return list;
    }

    private Integer countVolume(LinkedList<Request> list, Double price) {
        Integer volume = 0;
        for (int bidCell = 0; bidCell < list.size(); bidCell++) {
            Request bidRequest = list.get(bidCell);
            if (bidRequest.getPrice().equals(price)) {
                volume += bidRequest.getVolume();
            }
        }
        return volume;
    }

    private LinkedList<Double> createPriceList() {
        LinkedList<Double> priceList = new LinkedList<>();
        for (int bidCell = 0; bidCell < bidLinkedList.size(); bidCell++) {
            Request bidRequest = bidLinkedList.get(bidCell);
            if (!priceList.contains(bidRequest.getPrice())) {
                priceList.add(bidRequest.getPrice());
            }
        }
        for (int askCell = 0; askCell < askLinkedList.size(); askCell++) {
            Request askRequest = askLinkedList.get(askCell);
            if (!priceList.contains(askRequest.getPrice())) {
                priceList.add(askRequest.getPrice());
            }
        }
        priceList.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return  -o1.compareTo(o2);
            }
        });
        return priceList;
    }

    public void print() {
        LinkedList<Double> priceList = createPriceList();
        Iterator priceListIterator = priceList.listIterator();
        while (priceListIterator.hasNext()) {
            Double price = (Double) priceListIterator.next();
            Integer volumeBid = countVolume(bidLinkedList, price);
            Integer volumeAsk = countVolume(askLinkedList, price);
            printList.add(new PrintLine(price, volumeBid, volumeAsk));
        }
        System.out.println("Bid  Price  Ask");
        for (int printCell = 0; printCell < printList.size(); printCell++) {
            PrintLine printLine = printList.get(printCell);
            StringJoiner stringJoiner = new StringJoiner("  ");
            stringJoiner.add(printLine.getVolumeBid().toString());
            stringJoiner.add(String.format("%.2f", printLine.getPrice()));
            stringJoiner.add(printLine.getVolumeAsk().toString());
            System.out.println(stringJoiner.toString());
        }
    }

    public void sort() {
        this.bidLinkedList.sort(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                return  -o1.getPrice().compareTo(o2.getPrice());
            }
        });
        this.askLinkedList.sort(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                return  -o1.getPrice().compareTo(o2.getPrice());
            }
        });
    }


    public boolean add(Request request) {
        boolean added = false;
        LinkedList<Request> list = whatList(request);
        list.add(request);
        sort();
        return added;
    }

    public boolean delete(Request request) {
        boolean deleted = false;
        LinkedList<Request> list = whatList(request);
        list.remove(request);
        return deleted;
    }

    public boolean processed(Request request) {
        boolean processed = false;
        if (request != null) {
            if (request.getType() == "ADD") {
                processed = add(request);
            } else if (request.getType() == "DELETE") {
                processed = delete(request);
            }
        }
        return processed;
    }

    public void combine() {
        if (!bidLinkedList.isEmpty() && !askLinkedList.isEmpty()) {
            Iterator askIterator = askLinkedList.iterator();
            while (askIterator.hasNext()) {
                Request askRequest = (Request) askIterator.next();
                Iterator bidIterator = bidLinkedList.iterator();
                boolean wasCombine = false;
                while (bidIterator.hasNext() && !wasCombine) {
                    Request bidRequest = (Request) bidIterator.next();
                    if (askRequest.getPrice() <= bidRequest.getPrice()) {
                        wasCombine = true;
                        Integer volume = askRequest.getVolume() - bidRequest.getVolume();
                        if (volume == 0) {
                            bidLinkedList.remove(bidRequest);
                            askLinkedList.remove(askRequest);
                        } else if (volume > 0) {
                            askRequest.setVolume(volume);
                            bidLinkedList.remove(bidRequest);
                        } else if (volume < 0) {
                            bidRequest.setVolume(-volume);
                            askLinkedList.remove(askRequest);
                        }
                    }
                }
            }
        }
    }


    public LinkedList<Request> getBidLinkedList() {
        return this.bidLinkedList;
    }

    public Glass(Integer book) {
        this.book = book;
        this.bidLinkedList = new LinkedList<>();
        this.askLinkedList = new LinkedList<>();
        this.printList = new LinkedList<>();
    }


}
