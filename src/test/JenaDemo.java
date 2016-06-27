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
	 * jena��������
	 */
	public static void fun1(OntModel model){
		//����һ������Ϊģ����Animal��ĵȼ��࣬�����ע��
		//OntClass cls=model.createClass(":DongwuClass");
		//cls.addComment("the EquivalentClass of Animal...", "EN");
		//ͨ��������URIȡ��ģ���е�Animal��
		//OntClass oc=model.getOntClass("http://www.semanticweb.org/bugd/ontologies/2016/4/untitled-ontology-14#Animal");
		//oc.addEquivalentClass(cls);
		
		/*
		 * ������ʾģ���е��࣬���ڵ�����������ɸ��ֲ���
		 */
		for(Iterator<OntClass> i=model.listClasses();i.hasNext();){
			OntClass c=(OntClass)i.next();
//			if(!c.isAnon()){//�������������
//				System.out.print("Class:");
//				//��ȡ���URI������������ʱ��URI���˼�
//				System.out.println(c.getModel().getGraph().getPrefixMapping().shortForm(c.getURI()));
//				//�������ΪAnimal��
////				if(c.getLocalName().equals("Animal")){
////					System.out.println("URI@"+c.getURI());
////				}
//			}
			//������ʾ��ǰ���ֱ�Ӹ���
			for(Iterator<OntClass> i2=c.listSuperClasses();i2.hasNext();){
				OntClass c2=(OntClass)i2.next();
				String str=c.getModel().getGraph().getPrefixMapping().shortForm(c.getURI())+"'s superClass is";
				str=str+":"+c2.getURI().substring(c2.getURI().indexOf("#")+1);
				System.out.println("Class "+str);
			}
			
			//������ʾ�뵱ǰ����ص���������
			for(Iterator<OntProperty> i3=c.listDeclaredProperties();i3.hasNext();){
				OntProperty p=(OntProperty)i3.next();
				System.out.println("associated property:"+p.getLocalName());
			}
			
		}
	}
	
}
