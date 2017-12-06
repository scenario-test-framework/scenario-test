# scenario-test-framework
#---------------------------------------------------------------------
# テスト実施は selenium-grid
#---------------------------------------------------------------------

FROM openjdk:8-jdk

# chromeとfirefoxのインストール
RUN apt-get update -y
RUN apt-get install -y             \
    maven

# pomのみの状態でビルドし、ローカルリポジトリに依存ファイルダウンロード
RUN mkdir -p ~/scenario-test
COPY ./pom.xml /root/scenario-test
COPY ./entry-point.sh /root/scenario-test
RUN chmod +x /root/scenario-test/entry-point.sh && \
    /root/scenario-test/entry-point.sh init

RUN apt-get clean               && \
    rm -rf /var/lib/apt/lists/*

# テスト実行
ENTRYPOINT ["/root/scenario-test/entry-point.sh"]
CMD ["test"]
