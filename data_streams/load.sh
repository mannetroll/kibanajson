#!/bin/bash

curl -is -XPUT -H "Content-Type: application/json" http://localhost:9200/_ilm/policy/logstash-policy -d @logstash-policy.json

curl -is -XPUT -H "Content-Type: application/json" http://localhost:9200/_component_template/logstash-mappings -d @logstash-mappings.json

curl -is -XPUT -H "Content-Type: application/json" http://localhost:9200/_component_template/logstash-settings -d @logstash-settings.json
	
curl -is -XPUT -H "Content-Type: application/json" http://localhost:9200/_index_template/logstash-template -d @logstash-template.json

#
#  curl -is -XPOST -H "Content-Type: application/json" http://localhost:9200/logstash/_doc -d @logrow.json
#  curl -is -XPOST -H "Content-Type: application/json" http://localhost:9200/logstash-pia/_doc -d @logrow.json#

# 
# _data_stream
#
# GET _data_stream
# GET _data_stream?filter_path=data_streams.name
# GET _data_stream/_stats
#
