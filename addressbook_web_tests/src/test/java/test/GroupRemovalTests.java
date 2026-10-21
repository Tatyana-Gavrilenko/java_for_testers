package test;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.group().getCount() == 0) {
            app.group().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        int groupCount = app.group().getCount();
         app.group().removeGroup();
        int newGroupCount = app.group().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }

}