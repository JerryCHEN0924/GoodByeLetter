package com.iSpanProject.GoodByeletter.Jerry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@ExtendWith(MockitoExtension.class) //設置Mockito測試環境
@DisplayName("Jerry功能測試-LastNoteDao")
public class LastNoteDaoTest {
	
	@Mock
    private LastNoteDao lastNoteDao;//@MOCK模擬LastNoteDao
	
	@Test
	@DisplayName("FindLastNoteVerifyTimeQuery")
    void testFindLastNoteVerifyTimeQuery() {
		//Arrange 準備
        LocalDate date = LocalDate.now();
        LastNote note1 = new LastNote();
        LastNote note2 = new LastNote();
        
        //Act
        when(lastNoteDao.findLastNoteVerifyTimeQuery(date)).thenReturn(Arrays.asList(note1, note2));

        List<LastNote> notes = lastNoteDao.findLastNoteVerifyTimeQuery(date);
        
        //Assert斷言
        assertNotNull(notes);
        assertEquals(2, notes.size());
    }
	
	@Test
	@DisplayName("FindByVerificationCode")
    void testFindByVerificationCode() {
        String token = "123456";
        LastNote note = new LastNote();
        
        when(lastNoteDao.findByverificationCode(token)).thenReturn(note);

        LastNote foundNote = lastNoteDao.findByverificationCode(token);
        
        assertNotNull(foundNote);
        assertEquals(note, foundNote);
    }

    @Test
    @DisplayName("ExistsByVerificationCode")
    void testExistsByVerificationCode() {
        String token = "123456";
        
        when(lastNoteDao.existsByverificationCode(token)).thenReturn(true);

        boolean exists = lastNoteDao.existsByverificationCode(token);
        
        assertTrue(exists);
    }

    @Test
    @DisplayName("FindByEnabledFalse")
    void testFindByEnabledFalse() {
        LastNote note1 = new LastNote();
        LastNote note2 = new LastNote();
        
        when(lastNoteDao.findByenabledFalse()).thenReturn(Arrays.asList(note1, note2));

        List<LastNote> notes = lastNoteDao.findByenabledFalse();
        
        assertNotNull(notes);
        assertEquals(2, notes.size());
    }

    @Test
    @DisplayName("FindLastNoteByMemberId")
    void testFindLastNoteByMemberId() {
        Register r = new Register();
        LastNote note1 = new LastNote();
        LastNote note2 = new LastNote();
        
        when(lastNoteDao.findLastNoteBymemberId(r)).thenReturn(Arrays.asList(note1, note2));

        List<LastNote> notes = lastNoteDao.findLastNoteBymemberId(r);
        
        assertNotNull(notes);
        assertEquals(2, notes.size());
    }
	
}
