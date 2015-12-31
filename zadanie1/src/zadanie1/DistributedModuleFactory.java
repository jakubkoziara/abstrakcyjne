package zadanie1;

public interface DistributedModuleFactory {
	public Data CreateData();
	    public Exporter CreateExporter();
	    public Importer CreateImporter();
}
