package org.nanotek.meta.model;

import java.util.Optional;

@FunctionalInterface
public interface Classifier<CI> {
	
	 Optional<CI> classify(CI classified);
	
}
