package org.nanotek.meta.model.rdbms;

import java.util.List;
import java.util.Optional;

import org.nanotek.meta.model.classification.MetaClassClassifier;

/** 
 * A basic join table classifier, which means that all attributes are foreign-keys.
 * this classifier does not consider a "relationship table" that owns a primary key(for now).
 */
public class JoinTableClassifier extends MetaClassClassifier<RdbmsMetaClass> {

	@Override
	public Optional<RdbmsMetaClass> classify(RdbmsMetaClass classified) {
		if(verifyClassForeignKeys(classified))
			return Optional.of (classified);
		return Optional.<RdbmsMetaClass>empty();
	}
//TODO: optimize this algorithm
	private boolean verifyClassForeignKeys(RdbmsMetaClass classified) {
		int counter = classified.getRdbmsForeignKeys().size();
		if(counter>0 && classified.getRdbmsForeignKeys().size() == classified.getMetaAttributes().size()){
			var attList = classified.getMetaAttributes();
			for (var fk : classified.getRdbmsForeignKeys()) {
				 if(verifyJoinAttribute(fk.getJoinColumnName(),attList)){
					 counter--;
				 }
			}
		}else {
			counter = Integer.MIN_VALUE;
		}
		return counter==0;
	}

	private boolean verifyJoinAttribute(String joinColumnName, List<RdbmsMetaClassAttribute> attList) {
		return attList.stream().filter(att -> att.getColumnName().equals(joinColumnName)).count()==1;
	}

}
