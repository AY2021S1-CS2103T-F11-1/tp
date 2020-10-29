package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.attendance.Attendance;


/**
 * Contains integration and unit tests for ShowAttendanceCommandTest.
 */
public class ShowAttendanceCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void presentAttendance() {
        Attendance attendance = Attendance.fromDateString("27/03/1998");
        String message = "Alice Pauline was present on Fri Mar 27 00:00:00 SGT 1998";

        ShowAttendanceCommand showAttendanceCommand = new ShowAttendanceCommand(INDEX_FIRST_PERSON, attendance);
        assertCommandSuccess(showAttendanceCommand, model, message, expectedModel);
    }

    @Test
    public void absentAttendance() {
        Attendance attendance = Attendance.fromDateString("28/03/1998");
        String message = "Alice Pauline was absent on Sat Mar 28 00:00:00 SGT 1998";

        ShowAttendanceCommand showAttendanceCommand = new ShowAttendanceCommand(INDEX_FIRST_PERSON, attendance);
        assertCommandSuccess(showAttendanceCommand, model, message, expectedModel);
    }
}
