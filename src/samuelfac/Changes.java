package samuelfac;


public class Changes {

    private String field;
    private String valueBefore;
    private String valueAfter;
    
    public Changes(String field, String valueBefore, String valueAfter) {
        super();
        this.field = field;
        this.valueBefore = valueBefore;
        this.valueAfter = valueAfter;
    }

    public String getField() {
        return field;
    }
    
    public void setField(String field) {
        this.field = field;
    }
    
    public String getValueBefore() {
        return valueBefore;
    }
    
    public void setValueBefore(String valueBefore) {
        this.valueBefore = valueBefore;
    }
    
    public String getValueAfter() {
        return valueAfter;
    }
    
    public void setValueAfter(String valueAfter) {
        this.valueAfter = valueAfter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Changes [");
        if (field != null) {
            builder.append("field=");
            builder.append(field);
            builder.append(", ");
        }
        if (valueBefore != null) {
            builder.append("valueBefore=");
            builder.append(valueBefore);
            builder.append(", ");
        }
        if (valueAfter != null) {
            builder.append("valueAfter=");
            builder.append(valueAfter);
        }
        builder.append("]");
        return builder.toString();
    }
}
