package test;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;

public class JenaDemo {
	public static void main(String[] args) {
		OntModel model=ModelFactory.createOntologyModel();
		try {
			model.read("D:\\protega\\file\\Expert.owl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//String rules="[Rule 1:(? x refers ? y),(? y subclass of ? z) -> (? x refers to ? z)]";
		//Reasoner reasoner=new GenericRuleReasoner(Rule.parseRules(rules));
		fun1(model);
		
	}
	
	/**
	 * jena迭代操作
	 */
	public static void fun1(OntModel model){
		//定义一个类作为模型中Animal类的等价类，并添加注释
		//OntClass cls=model.createClass(":DongwuClass");
		//cls.addComment("the EquivalentClass of Animal...", "EN");
		//通过完整的URI取得模型中的Animal类
		//OntClass oc=model.getOntClass("http://www.semanticweb.org/bugd/ontologies/2016/4/untitled-ontology-14#Animal");
		//oc.addEquivalentClass(cls);
		
		/*
		 * 迭代显示模型中的类，并在迭代过程中完成各种操作
		 */
		for(Iterator<OntClass> i=model.listClasses();i.hasNext();){
			OntClass c=(OntClass)i.next();
//			if(!c.isAnon()){//如果不是匿名类
//				System.out.print("Class:");
//				//获取类的URI并输出，在输出时对URI做了简化
//				System.out.println(c.getModel().getGraph().getPrefixMapping().shortForm(c.getURI()));
//				//如果此类为Animal类
////				if(c.getLocalName().equals("Animal")){
////					System.out.println("URI@"+c.getURI());
////				}
//			}
			//迭代显示当前类的直接父类
			for(Iterator<OntClass> i2=c.listSuperClasses();i2.hasNext();){
				OntClass c2=(OntClass)i2.next();
				String str=c.getModel().getGraph().getPrefixMapping().shortForm(c.getURI())+"'s superClass is";
				str=str+":"+c2.getURI().substring(c2.getURI().indexOf("#")+1);
				System.out.println("Class "+str);
			}
			
			//迭代显示与当前类相关的所有属性
			for(Iterator<OntProperty> i3=c.listDeclaredProperties();i3.hasNext();){
				OntProperty p=(OntProperty)i3.next();
				System.out.println("associated property:"+p.getLocalName());
			}
			
		}
	}
	
}
