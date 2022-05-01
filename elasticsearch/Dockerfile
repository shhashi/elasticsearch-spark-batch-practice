# Elasticsearch
FROM docker.elastic.co/elasticsearch/elasticsearch:8.1.2

# 設定ファイルをコピー
COPY ./elasticsearch.yml /usr/share/elasticsearch/config/elasticsearch.yml

# 環境変数
## パスワード
ENV ELASTIC_PASSWORD=p@55W0RD
