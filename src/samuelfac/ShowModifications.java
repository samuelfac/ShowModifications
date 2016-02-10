package samuelfac;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class ShowModifications {
    
    public String returnStringChanges(Object oBefore, Object oAfter) throws Exception {
        ArrayList<Changes> listChanges = returnListChanges(oBefore, oAfter);
        String ret = "";
        for (Changes change : listChanges) {
            ret+=Messages.getString("ShowModifications.startMessage")+change.getField()+Messages.getString("ShowModifications.endFieldMessageChange") + change.getValueBefore() + Messages.getString("ShowModifications.to") + change.getValueAfter() + "';\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }
        if(ret.endsWith("\n")){ //$NON-NLS-1$
            ret = ret.substring(0, ret.length()-1);
        }
        return ret;
    }
    
    public ArrayList<Changes> returnListChanges(Object oBefore, Object oAfter) throws Exception {
        ArrayList<Changes> listChanges = new ArrayList<Changes>();
        
        if(!oBefore.getClass().equals(oAfter.getClass())){
            throw new Exception(Messages.getString("ShowModifications.msgObjectsDifferent")); //$NON-NLS-1$
        }
        Field f[] = oBefore.getClass().getDeclaredFields();  

        for (int i = 0; i < f.length; i++) {  
            Field field = f[i];  
            if(!field.toGenericString().contains(" static ") && //$NON-NLS-1$
            !getValueFromField(oBefore, field).equals(getValueFromField(oAfter, field))){
                listChanges.add(new Changes(field.getName(), getValueFromField(oBefore, field), getValueFromField(oAfter, field)));
            }
        }
        return listChanges;
    }

    private String getValueFromField(Object object, Field f) throws Exception{
        try{
            Field field = object.getClass().getDeclaredField(f.getName());
            field.setAccessible(true);
            Object value = field.get(object);
            return value.toString();
        }catch(NullPointerException e){
            return "null"; //$NON-NLS-1$
        }catch(Exception e){
            e.printStackTrace();
            return ""; //$NON-NLS-1$
        }
    }

}
