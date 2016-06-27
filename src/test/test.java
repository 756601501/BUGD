package test;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

public class test {
	
	/**
	 * ����Expert
	 */
	public static void testExpert() {
		String ruleFile = "D:\\protega\\file\\Expert.rules";
		String ontoFile = "D:\\protega\\file\\Expert.owl";
		
		IReasoner famRea = ReasonerFactory.createFamilyReasoner();
		
		Model m = FileManager.get().loadModel("D:\\protega\\file\\Expert.owl");
		String NS = "http://www.owl-ontologies.com/Expert.owl#";
		Resource r1 = m.getResource(NS + "Alice");
		Resource r2 = m.getResource(NS + "Computer_Applied_Technology");
		
		famRea.getInfModel(ruleFile, ontoFile);
		famRea.printInferResult(r1, r2);
	}
	

	/**
	 * ����Query
	 */
	public static void testQuery() {
		String ruleFile = "D:\\protega\\file\\Expert.rules";
		String ontoFile = "D:\\protega\\file\\Expert.owl";
		String queryString = "PREFIX Expert:<http://www.owl-ontologies.com/Expert.owl#> " +
	    	"SELECT ?expert ?subject " +
	    	"WHERE {?expert Expert:familiar_with ?subject} ";
		
		IReasoner famRea = ReasonerFactory.createFamilyReasoner();
		famRea.getInfModel(ruleFile, ontoFile);
		famRea.searchOnto(queryString);
	}

	public static void main(String[] args) {
		testExpert();
		
	}
	
}
