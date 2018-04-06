package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    @Test
    public void whenAddRole() {
        RoleStore rs = new RoleStore();
        Role role0 = new Role("Role1");
        rs.list.add(role0);
        rs.list.add(new Role("Role2"));
        rs.list.add(new Role("Role3"));
        assertThat(rs.list.get(0), is(role0));
    }


    @Test
    public void whenReplace() {
        RoleStore rs = new RoleStore();
        Role role0 = new Role("Role1");
        Role roleReplace = new Role("RoleReplace");
        rs.list.add(role0);
        rs.list.add(new Role("Role2"));
        rs.list.add(new Role("Role3"));
        rs.list.resetIndexForTest();
        boolean replaceDone = rs.replace("Role2", (Base) roleReplace);
        assertThat(rs.list.get(1), is(roleReplace));
    }


    @Test
    public void whenDelete() {
        RoleStore rs = new RoleStore();
        Role role0 = new Role("Role0");
        Role role1 = new Role("Role1");
        rs.list.add(role0);
        rs.list.add(role1);
        rs.list.add(new Role("Role2"));
        rs.list.resetIndexForTest();
        boolean deleteDone = rs.delete("Role0");
        assertThat(rs.list.get(0), is(role1));
    }

    @Test
    public void whenFindId() {
        RoleStore rs = new RoleStore();
        Role role0 = new Role("Role0");
        Role role1 = new Role("Role1");
        rs.list.add(role0);
        rs.list.add(role1);
        rs.list.add(new Role("Role2"));
        rs.list.resetIndexForTest();
        Base find = (Base) rs.findById("Role1");
        assertThat(find, is((Base) role1));
    }
}