import java.util.ArrayList;

public class RecordList {
    private ArrayList<Record> recordList;

    public RecordList(){
        recordList = new ArrayList<>();
    }

    public boolean addRecord(Record record){
        return recordList.add(record);
    }

    public Record removeRecord(int id){
        for (Record r: recordList) {
            if(r.getId() == id){
                Record temp = new Record(r);
                recordList.remove(r);
                return temp;
            }
        }
        return null;
    }

    public Record getRecord(int id){
        for (Record record : recordList) {
            if(record.getId() == id){
                return record;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return recordList.isEmpty();
    }

    public String toString(){
        if (isEmpty()){
            return "";
        }
        String result = "";
        for (Record record : recordList) {
            result += record.toString();
        }
        return result;
    }
}
