# scenario-test-framework
#---------------------------------------------------------------------

FROM alpine:edge

# 環境インストール
RUN apk update
RUN apk add                        \
    openjdk8                       \
    bash

RUN mkdir -p ~/scenario-test
COPY ./entry-point.sh /root/scenario-test
RUN chmod +x /root/scenario-test/entry-point.sh && \
    /root/scenario-test/entry-point.sh init

# テスト実行
ENTRYPOINT ["/root/scenario-test/entry-point.sh"]
CMD ["test"]
