package org.nanotek.meta.model;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.TagInterface;

@TagInterface
@FunctionalInterface
public interface Classifier<CI> {
	
	 Optional<CI> classify(CI classified);
	
}
