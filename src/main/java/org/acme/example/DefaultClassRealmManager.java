package org.acme.example;

import org.apache.maven.classrealm.ClassRealmManager;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.codehaus.plexus.classworlds.realm.ClassRealm;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.sisu.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

/**
 * Example of JSR330 component: this component is defined as JSR330 in core, and overriding it is simple as this.
 */
@Singleton
@Named
@Priority(10)
public class DefaultClassRealmManager implements ClassRealmManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final org.apache.maven.classrealm.DefaultClassRealmManager delegate;

    @Inject
    public DefaultClassRealmManager(org.apache.maven.classrealm.DefaultClassRealmManager delegate) {
        this.delegate = delegate;
    }

    @Override
    public ClassRealm getCoreRealm() {
        logger.info("ACME getCoreRealm");
        return delegate.getCoreRealm();
    }

    @Override
    public ClassRealm getMavenApiRealm() {
        logger.info("ACME getMavenApiRealm");
        return delegate.getMavenApiRealm();
    }

    @Override
    public ClassRealm createProjectRealm(Model model, List<Artifact> list) {
        logger.info("ACME createProjectRealm");
        return delegate.createProjectRealm(model, list);
    }

    @Override
    public ClassRealm createExtensionRealm(Plugin plugin, List<Artifact> list) {
        logger.info("ACME createExtensionRealm");
        return delegate.createExtensionRealm(plugin, list);
    }

    @Override
    public ClassRealm createPluginRealm(Plugin plugin, ClassLoader classLoader, List<String> list, Map<String, ClassLoader> map, List<Artifact> list1) {
        logger.info("ACME createPluginRealm");
        return delegate.createPluginRealm(plugin, classLoader, list, map, list1);
    }
}
