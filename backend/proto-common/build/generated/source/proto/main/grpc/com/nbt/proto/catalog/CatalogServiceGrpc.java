package com.nbt.proto.catalog;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: catalog_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CatalogServiceGrpc {

  private CatalogServiceGrpc() {}

  public static final String SERVICE_NAME = "com.nbt.proto.catalog.CatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.catalog.CreateServiceRequest,
      com.nbt.proto.catalog.ServiceItem> getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.nbt.proto.catalog.CreateServiceRequest.class,
      responseType = com.nbt.proto.catalog.ServiceItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.catalog.CreateServiceRequest,
      com.nbt.proto.catalog.ServiceItem> getCreateServiceMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.catalog.CreateServiceRequest, com.nbt.proto.catalog.ServiceItem> getCreateServiceMethod;
    if ((getCreateServiceMethod = CatalogServiceGrpc.getCreateServiceMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getCreateServiceMethod = CatalogServiceGrpc.getCreateServiceMethod) == null) {
          CatalogServiceGrpc.getCreateServiceMethod = getCreateServiceMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.catalog.CreateServiceRequest, com.nbt.proto.catalog.ServiceItem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.catalog.CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.catalog.ServiceItem.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("CreateService"))
              .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.catalog.GetServiceRequest,
      com.nbt.proto.catalog.ServiceItem> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.nbt.proto.catalog.GetServiceRequest.class,
      responseType = com.nbt.proto.catalog.ServiceItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.catalog.GetServiceRequest,
      com.nbt.proto.catalog.ServiceItem> getGetServiceMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.catalog.GetServiceRequest, com.nbt.proto.catalog.ServiceItem> getGetServiceMethod;
    if ((getGetServiceMethod = CatalogServiceGrpc.getGetServiceMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetServiceMethod = CatalogServiceGrpc.getGetServiceMethod) == null) {
          CatalogServiceGrpc.getGetServiceMethod = getGetServiceMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.catalog.GetServiceRequest, com.nbt.proto.catalog.ServiceItem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.catalog.GetServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.catalog.ServiceItem.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetService"))
              .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.catalog.ListServicesRequest,
      com.nbt.proto.catalog.ListServicesResponse> getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.nbt.proto.catalog.ListServicesRequest.class,
      responseType = com.nbt.proto.catalog.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.catalog.ListServicesRequest,
      com.nbt.proto.catalog.ListServicesResponse> getListServicesMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.catalog.ListServicesRequest, com.nbt.proto.catalog.ListServicesResponse> getListServicesMethod;
    if ((getListServicesMethod = CatalogServiceGrpc.getListServicesMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListServicesMethod = CatalogServiceGrpc.getListServicesMethod) == null) {
          CatalogServiceGrpc.getListServicesMethod = getListServicesMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.catalog.ListServicesRequest, com.nbt.proto.catalog.ListServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.catalog.ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.catalog.ListServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ListServices"))
              .build();
        }
      }
    }
    return getListServicesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub>() {
        @java.lang.Override
        public CatalogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceStub(channel, callOptions);
        }
      };
    return CatalogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CatalogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub>() {
        @java.lang.Override
        public CatalogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceBlockingStub(channel, callOptions);
        }
      };
    return CatalogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CatalogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub>() {
        @java.lang.Override
        public CatalogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceFutureStub(channel, callOptions);
        }
      };
    return CatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createService(com.nbt.proto.catalog.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ServiceItem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceMethod(), responseObserver);
    }

    /**
     */
    default void getService(com.nbt.proto.catalog.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ServiceItem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     */
    default void listServices(com.nbt.proto.catalog.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ListServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServicesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CatalogService.
   */
  public static abstract class CatalogServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CatalogServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CatalogService.
   */
  public static final class CatalogServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CatalogServiceStub> {
    private CatalogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceStub(channel, callOptions);
    }

    /**
     */
    public void createService(com.nbt.proto.catalog.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ServiceItem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getService(com.nbt.proto.catalog.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ServiceItem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listServices(com.nbt.proto.catalog.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ListServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CatalogService.
   */
  public static final class CatalogServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CatalogServiceBlockingStub> {
    private CatalogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.nbt.proto.catalog.ServiceItem createService(com.nbt.proto.catalog.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nbt.proto.catalog.ServiceItem getService(com.nbt.proto.catalog.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nbt.proto.catalog.ListServicesResponse listServices(com.nbt.proto.catalog.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CatalogService.
   */
  public static final class CatalogServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CatalogServiceFutureStub> {
    private CatalogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.catalog.ServiceItem> createService(
        com.nbt.proto.catalog.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.catalog.ServiceItem> getService(
        com.nbt.proto.catalog.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.catalog.ListServicesResponse> listServices(
        com.nbt.proto.catalog.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SERVICE = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_LIST_SERVICES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService((com.nbt.proto.catalog.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ServiceItem>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((com.nbt.proto.catalog.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ServiceItem>) responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices((com.nbt.proto.catalog.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.catalog.ListServicesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.catalog.CreateServiceRequest,
              com.nbt.proto.catalog.ServiceItem>(
                service, METHODID_CREATE_SERVICE)))
        .addMethod(
          getGetServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.catalog.GetServiceRequest,
              com.nbt.proto.catalog.ServiceItem>(
                service, METHODID_GET_SERVICE)))
        .addMethod(
          getListServicesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.catalog.ListServicesRequest,
              com.nbt.proto.catalog.ListServicesResponse>(
                service, METHODID_LIST_SERVICES)))
        .build();
  }

  private static abstract class CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.nbt.proto.catalog.CatalogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CatalogService");
    }
  }

  private static final class CatalogServiceFileDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier {
    CatalogServiceFileDescriptorSupplier() {}
  }

  private static final class CatalogServiceMethodDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CatalogServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CatalogServiceFileDescriptorSupplier())
              .addMethod(getCreateServiceMethod())
              .addMethod(getGetServiceMethod())
              .addMethod(getListServicesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
