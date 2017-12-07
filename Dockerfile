# scenario-test-framework
#---------------------------------------------------------------------

FROM alpine:edge

# コンパイル環境インストール
RUN apk update
RUN apk add                        \
    openjdk8                       \
    maven                          \
    bash

# 初回ビルド
RUN mkdir -p ~/scenario-test
COPY ./pom.xml /root/scenario-test
COPY ./entry-point.sh /root/scenario-test
RUN chmod +x /root/scenario-test/entry-point.sh && \
    /root/scenario-test/entry-point.sh init

# ビルド・テスト実行
ENTRYPOINT ["/root/scenario-test/entry-point.sh"]
CMD ["test"]
