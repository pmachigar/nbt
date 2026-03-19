function fn() {
    var port = karate.properties['grpc.port'] || 9091;
    var config = {
        grpcHost: 'localhost',
        grpcPort: port
    };
    return config;
}
