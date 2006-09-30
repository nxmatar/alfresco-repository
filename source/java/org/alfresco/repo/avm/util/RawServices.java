/**
 * 
 */
package org.alfresco.repo.avm.util;

import org.alfresco.repo.content.ContentStore;
import org.alfresco.repo.security.authentication.AuthenticationComponent;
import org.alfresco.service.cmr.dictionary.DictionaryService;
import org.alfresco.service.cmr.repository.ContentService;
import org.alfresco.service.cmr.repository.MimetypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Simple access to Raw versions of service singletons.
 * @author britt
 */
public class RawServices implements ApplicationContextAware
{
    /**
     * The instance of RawServices
     */
    private static RawServices fgInstance;
    
    /**
     * The Application Context.
     */
    private ApplicationContext fContext; 
    
    /**
     * The AuthenticationComponent.
     */
    private AuthenticationComponent fAuthenticationComponent;
    
    /**
     * The Content Service.
     */
    private ContentService fContentService;
    
    /**
     * The Mimetype Service.
     */
    private MimetypeService fMimetypeService;
    
    /**
     * The Dictionary Service.
     */
    private DictionaryService fDictionaryService;
    
    /**
     * The Content Store.
     */
    private ContentStore fContentStore;
    
    /**
     * Default constructor.
     */
    public RawServices()
    {
        fgInstance = this;    
    }
    
    public static RawServices Instance()
    {
        return fgInstance;
    }
    
    public void setApplicationContext(ApplicationContext applicationContext)
    {
        fContext = applicationContext;
    }
    
    public AuthenticationComponent getAuthenticationComponent()
    {
        if (fAuthenticationComponent == null)
        {
            fAuthenticationComponent = 
                (AuthenticationComponent)fContext.getBean("authenticationComponent");
        }
        return fAuthenticationComponent;
    }

    public ContentService getContentService()
    {
        if (fContentService == null)
        {
            fContentService = 
                (ContentService)fContext.getBean("contentService");
        }
        return fContentService;
    }

    public MimetypeService getMimetypeService()
    {
        if (fMimetypeService == null)
        {
            fMimetypeService = 
                (MimetypeService)fContext.getBean("mimetypeService");
        }
        return fMimetypeService;
    }
    
    public DictionaryService getDictionaryService()
    {
        if (fDictionaryService == null)
        {
            fDictionaryService =
                (DictionaryService)fContext.getBean("dictionaryService");
        }
        return fDictionaryService;
    }
    
    public ContentStore getContentStore()
    {
        if (fContentStore == null)
        {
            fContentStore =
                (ContentStore)fContext.getBean("fileContentStore");
        }
        return fContentStore;
    }
    
    public ApplicationContext getContext()
    {
        return fContext;
    }
}
