FROM alpine

COPY  ./otelcontribcol_linux_amd64 /otelcontribcol
RUN chmod 777 /otelcontribcol
RUN ls -l /otelcontribcol
ENTRYPOINT ["/otelcontribcol"]
EXPOSE 4317 55680 55679
