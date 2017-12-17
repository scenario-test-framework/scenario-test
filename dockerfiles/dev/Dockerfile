# scenario-test-framework
#---------------------------------------------------------------------

FROM openjdk:8-jre-alpine

# 環境インストール
RUN apk update
RUN apk add                        \
    bash \
    maven

RUN mkdir -p ~/scenario-test
COPY ./dockerfiles/dev/entry-point.sh /root/scenario-test
RUN chmod +x /root/scenario-test/entry-point.sh && \
    /root/scenario-test/entry-point.sh init

# テスト実行
ENTRYPOINT ["/root/scenario-test/entry-point.sh"]
CMD ["test"]
