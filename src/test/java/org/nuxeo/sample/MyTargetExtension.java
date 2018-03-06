package org.nuxeo.sample;

import org.nuxeo.runtime.test.runner.TargetExtensions;
import org.nuxeo.ecm.platform.ec.notification.service.NotificationService;

public class MyTargetExtension extends TargetExtensions {
    @Override
    protected void initialize() {
        addTargetExtension("org.nuxeo.ecm.platform.ec.notification.service.NotificationService","templates");
    }
}
