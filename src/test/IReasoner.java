package test;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Resource;

/**
 * @purpose ����ӿڣ�ʵ�ֱ�������
 * @author bugd
 * 
 */
public interface IReasoner {

	/**
	 * ��ȡInfModel����
	 * @param ontPath
	 * @param rulePath
	 * @return
	 */
	public InfModel getInfModel(String ontPath, String rulePath);
	/**
	 * ��ȡInfModel����
	 * @param rulePath
	 * @param model
	 * @return
	 */
	public InfModel getInfModel(String rulePath, OntModel model);
	/**
	 * ��ӡ������
	 * @param a
	 * @param b
	 */
	public void printInferResult(Resource a, Resource b);
	/**
	 * ��ѯ
	 * @param queryString
	 */
	public void searchOnto(String queryString);
}
