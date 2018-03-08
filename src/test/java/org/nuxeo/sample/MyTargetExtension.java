package org.nuxeo.sample;

import org.nuxeo.runtime.test.runner.TargetExtensions;

public class MyTargetExtension extends TargetExtensions {
    @Override
    protected void initialize() {
        addTargetExtension("org.nuxeo.ecm.platform.ec.notification.service.NotificationService","templates");
    }
}
