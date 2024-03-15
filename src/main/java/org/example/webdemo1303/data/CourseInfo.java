package org.example.webdemo1303.data;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Course}
 */
public interface CourseInfo {
    Integer getId();

    @Value("#{target.title + ' (' +  target.length + ')' }" )
    String getDescription();
}