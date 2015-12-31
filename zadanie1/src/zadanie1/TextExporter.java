package zadanie1;

public class TextExporter implements Exporter {
    
    private Data data;
    
    public TextExporter(String textToBeExported){
        this.data = new TextData(textToBeExported);
    }
    
    
    public Data ExportData() {
        if (data == null) {
            return new TextData("");
        }
        
        Data exportedData = data;
        data = null;
        return exportedData; 
    }
    
   
    
}