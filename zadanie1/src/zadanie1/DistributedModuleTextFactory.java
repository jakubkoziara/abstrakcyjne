package zadanie1;

public class DistributedModuleTextFactory implements DistributedModuleFactory{
	 private String text;
	    
	    public DistributedModuleTextFactory(String textToForFactory) {
	        this.text = textToForFactory;
	    }

	    public Data CreateData() {
	        return new TextData(text);
	    }

	    public Exporter CreateExporter() {
	        return new TextExporter(text);
	    }

	    public Importer CreateImporter() {
	        return new TextImporter();
	    }

}
