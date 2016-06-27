package test;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Resource;

/**
 * @purpose 定义接口：实现本体推理
 * @author bugd
 * 
 */
public interface IReasoner {

	/**
	 * 获取InfModel对象
	 * @param ontPath
	 * @param rulePath
	 * @return
	 */
	public InfModel getInfModel(String ontPath, String rulePath);
	/**
	 * 获取InfModel对象
	 * @param rulePath
	 * @param model
	 * @return
	 */
	public InfModel getInfModel(String rulePath, OntModel model);
	/**
	 * 打印推理结果
	 * @param a
	 * @param b
	 */
	public void printInferResult(Resource a, Resource b);
	/**
	 * 查询
	 * @param queryString
	 */
	public void searchOnto(String queryString);
}
