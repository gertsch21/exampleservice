package org.omilab.services.exampleservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.omilab.services.exampleservice.rest.PSMConnectorAdmin;
import org.omilab.services.exampleservice.rest.PSMConnectorMgmt;
import org.omilab.services.exampleservice.rest.PSMConnectorView;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(PSMConnectorAdmin.class);
		register(PSMConnectorMgmt.class);
		register(PSMConnectorView.class);
	}

}
