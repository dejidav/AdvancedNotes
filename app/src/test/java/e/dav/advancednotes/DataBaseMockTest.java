package e.dav.advancednotes;

import android.content.Context;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.GregorianCalendar;

import e.dav.advancednotes.db.DbHelper;
import e.dav.advancednotes.db.NoteManager;
import e.dav.advancednotes.model.Note;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DataBaseMockTest {



    @Mock
    private NoteManager mNotemanager;
    private Note mNote;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testNoteSaved(){

        mNote = mock(Note.class);
        mNote.setId(1);
        mNotemanager.create(mNote);
        assertEquals(mNotemanager.getNote(1), mNote);


    }
}
