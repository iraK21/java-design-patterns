package org.example.structural.decorator;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Java API decorators are used especially in code related to streams.
 */
class JavaAPIDecoratorTest {
    @Test
    void testCollectionsDecorators() {
        Set<String> stringSet = new HashSet<>(); // Component is Set, ConcreteComponent is HashSet
        stringSet.add("string1");
        stringSet.add("string2");
        Set<String> unmodifiableStringSet = Collections.unmodifiableSet(stringSet); // unmodifiableSet is concrete decorator
        assertThat(unmodifiableStringSet)
                .isUnmodifiable()
                .containsExactlyInAnyOrderElementsOf(stringSet);
        Set<String> checkedStringSet = Collections.checkedSet(Collections.synchronizedSet(stringSet), String.class); // two nested concrete decorators
        assertThat(checkedStringSet)
                .hasOnlyElementsOfType(String.class)
                .containsExactlyInAnyOrderElementsOf(stringSet);
    }
}
