package exampro.config.core;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

import javax.servlet.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public static final Charset DEFAULT_CHARACTER_ENCODING = StandardCharsets.UTF_8;

    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        insertFilters(servletContext,
                createCharacterEncodingFilter(),
                createResourceUrlEncodingFilter());
    }

    static CharacterEncodingFilter createCharacterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(DEFAULT_CHARACTER_ENCODING.name());
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    static ResourceUrlEncodingFilter createResourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }

}