Create an index lifecycle policy

	PUT _ilm/policy/logstash-policy -d @logstash-policy.json

### Create component templates	

Creates a component template for mappings

	PUT _component_template/logstash-mappings -d @logstash-mappings.json

Creates a component template for index settings	

	PUT _component_template/logstash-settings -d @logstash-settings.json
	
Create an index template (with data_stream)

	PUT _index_template/logstash-template -d @logstash-template.json
	
### Create the data stream	

	PUT logstash/_bulk -d @import.ndjson

or

	POST logstash/_doc -d @logrow.json

