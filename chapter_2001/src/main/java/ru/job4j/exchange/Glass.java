package ru.job4j.exchange;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Glass {

    private static Integer book;
    private LinkedList<Request> bidLinkedList;
    private LinkedList<Request> askLinkedList;

    public LinkedList<Request> whatList(Request request) {
        LinkedList<Request> list = null;
        if (request.getAction() == Request.Action.BID) {
            list = bidLinkedList;
        } else if (request.getAction() ==  Request.Action.ASK) {
            list = askLinkedList;
        }
        return list;
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
            if (request.getType() == Request.Type.ADD) {
                processed = add(request);
            } else if (request.getType() == Request.Type.DELETE) {
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
                if (askRequest.getExist()) {
                    Iterator bidIterator = bidLinkedList.iterator();
                    boolean wasCombine = false;
                    while (bidIterator.hasNext() && !wasCombine) {
                        Request bidRequest = (Request) bidIterator.next();
                        if (bidRequest.getExist()) {
                            if (askRequest.getPrice() <= bidRequest.getPrice()) {
                                wasCombine = true;
                                Integer difference = askRequest.getVolume() - bidRequest.getVolume();
                                if (difference == 0) {
                                    bidRequest.setNotExist();
                                    askRequest.setNotExist();
                                } else if (difference > 0) {
                                    askRequest.setVolume(difference);
                                    bidRequest.setNotExist();
                                } else if (difference < 0) {
                                    bidRequest.setVolume(-difference);
                                    askRequest.setNotExist();
                                }
                            }
                        }
                    }
                }
            }
            removeNotExists();
        }
    }

    public void removeNotExists() {
        for (int i = 0; i < askLinkedList.size(); i++) {
            Request element = askLinkedList.get(i);
            if (!element.getExist()) {
                askLinkedList.remove(i);
            }
        }
        for (int i = 0; i < bidLinkedList.size(); i++) {
            Request element = bidLinkedList.get(i);
            if (!element.getExist()) {
                bidLinkedList.remove(i);
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
    }


}
