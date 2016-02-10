package samuelfac;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ShowModificationsTest {
    
    @Test
    public void returnStringChangesEN() throws Exception {
        ShowModifications showModifications = new ShowModifications();
        
        Locale.setDefault(Locale.ENGLISH);
        
        ObjectTest oBefore = new ObjectTest();
        oBefore.setField1("field1");
        oBefore.setField2("field2");
        oBefore.setField3(1);
        oBefore.setField4(new Date());
        
        ObjectTest oAfter = new ObjectTest();
        oAfter.setField1("field1");
        oAfter.setField2("field2Changed");
        oAfter.setField3(2);
        oAfter.setField4(new Date());
        
        String ret = showModifications.returnStringChanges(oBefore, oAfter);
        assertEquals("[field2] change from 'field2' to 'field2Changed';\n[field3] change from '1' to '2';", ret);
    }
    
    @Test
    public void returnStringChangesOK() throws Exception {
        ShowModifications showModifications = new ShowModifications();
        
        Locale.setDefault(Locale.ENGLISH);
        
        ObjectTest oBefore = new ObjectTest();
        oBefore.setField1("field1");
        oBefore.setField2("field2");
        oBefore.setField3(1);
        oBefore.setField4(new Date());
        
        ObjectTest oAfter = new ObjectTest();
        oAfter.setField1("field1");
        oAfter.setField2("field2");
        oAfter.setField3(1);
        oAfter.setField4(new Date());
        
        String ret = showModifications.returnStringChanges(oBefore, oAfter);
        assertEquals("", ret);
    }
    
    @Test
    public void returnListChangesEN() throws Exception {
        ShowModifications showModifications = new ShowModifications();
        
        Locale.setDefault(Locale.ENGLISH);
        
        ObjectTest oBefore = new ObjectTest();
        oBefore.setField1("field1");
        oBefore.setField2("field2");
        oBefore.setField3(1);
        oBefore.setField4(new Date());
        
        ObjectTest oAfter = new ObjectTest();
        oAfter.setField1("field1");
        oAfter.setField2("field2Changed");
        oAfter.setField3(2);
        oAfter.setField4(new Date());
        
        ArrayList<Changes> listChanges = showModifications.returnListChanges(oBefore, oAfter);
        assertEquals(2, listChanges.size());
    }
    
    @Test
    public void returnListChangesOK() throws Exception {
        ShowModifications showModifications = new ShowModifications();
        
        Locale.setDefault(Locale.ENGLISH);
        
        ObjectTest oBefore = new ObjectTest();
        oBefore.setField1("field1");
        oBefore.setField2("field2");
        oBefore.setField3(1);
        oBefore.setField4(new Date());
        
        ObjectTest oAfter = new ObjectTest();
        oAfter.setField1("field1");
        oAfter.setField2("field2");
        oAfter.setField3(1);
        oAfter.setField4(new Date());
        
        ArrayList<Changes> listChanges = showModifications.returnListChanges(oBefore, oAfter);
        assertEquals(true, listChanges.isEmpty());
    }
}
