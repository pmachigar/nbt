package com.nbt.proto.subscription;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: subscription_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SubscriptionServiceGrpc {

  private SubscriptionServiceGrpc() {}

  public static final String SERVICE_NAME = "com.nbt.proto.subscription.SubscriptionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.subscription.SubscribeRequest,
      com.nbt.proto.subscription.Subscription> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = com.nbt.proto.subscription.SubscribeRequest.class,
      responseType = com.nbt.proto.subscription.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.subscription.SubscribeRequest,
      com.nbt.proto.subscription.Subscription> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.subscription.SubscribeRequest, com.nbt.proto.subscription.Subscription> getSubscribeMethod;
    if ((getSubscribeMethod = SubscriptionServiceGrpc.getSubscribeMethod) == null) {
      synchronized (SubscriptionServiceGrpc.class) {
        if ((getSubscribeMethod = SubscriptionServiceGrpc.getSubscribeMethod) == null) {
          SubscriptionServiceGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.subscription.SubscribeRequest, com.nbt.proto.subscription.Subscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.subscription.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.subscription.Subscription.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriptionServiceMethodDescriptorSupplier("Subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.subscription.UnsubscribeRequest,
      com.nbt.proto.subscription.Subscription> getUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Unsubscribe",
      requestType = com.nbt.proto.subscription.UnsubscribeRequest.class,
      responseType = com.nbt.proto.subscription.Subscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.subscription.UnsubscribeRequest,
      com.nbt.proto.subscription.Subscription> getUnsubscribeMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.subscription.UnsubscribeRequest, com.nbt.proto.subscription.Subscription> getUnsubscribeMethod;
    if ((getUnsubscribeMethod = SubscriptionServiceGrpc.getUnsubscribeMethod) == null) {
      synchronized (SubscriptionServiceGrpc.class) {
        if ((getUnsubscribeMethod = SubscriptionServiceGrpc.getUnsubscribeMethod) == null) {
          SubscriptionServiceGrpc.getUnsubscribeMethod = getUnsubscribeMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.subscription.UnsubscribeRequest, com.nbt.proto.subscription.Subscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Unsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.subscription.UnsubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.subscription.Subscription.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriptionServiceMethodDescriptorSupplier("Unsubscribe"))
              .build();
        }
      }
    }
    return getUnsubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.subscription.GetUserSubscriptionsRequest,
      com.nbt.proto.subscription.GetUserSubscriptionsResponse> getGetUserSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserSubscriptions",
      requestType = com.nbt.proto.subscription.GetUserSubscriptionsRequest.class,
      responseType = com.nbt.proto.subscription.GetUserSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.subscription.GetUserSubscriptionsRequest,
      com.nbt.proto.subscription.GetUserSubscriptionsResponse> getGetUserSubscriptionsMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.subscription.GetUserSubscriptionsRequest, com.nbt.proto.subscription.GetUserSubscriptionsResponse> getGetUserSubscriptionsMethod;
    if ((getGetUserSubscriptionsMethod = SubscriptionServiceGrpc.getGetUserSubscriptionsMethod) == null) {
      synchronized (SubscriptionServiceGrpc.class) {
        if ((getGetUserSubscriptionsMethod = SubscriptionServiceGrpc.getGetUserSubscriptionsMethod) == null) {
          SubscriptionServiceGrpc.getGetUserSubscriptionsMethod = getGetUserSubscriptionsMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.subscription.GetUserSubscriptionsRequest, com.nbt.proto.subscription.GetUserSubscriptionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserSubscriptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.subscription.GetUserSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.subscription.GetUserSubscriptionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriptionServiceMethodDescriptorSupplier("GetUserSubscriptions"))
              .build();
        }
      }
    }
    return getGetUserSubscriptionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubscriptionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceStub>() {
        @java.lang.Override
        public SubscriptionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriptionServiceStub(channel, callOptions);
        }
      };
    return SubscriptionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscriptionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceBlockingStub>() {
        @java.lang.Override
        public SubscriptionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriptionServiceBlockingStub(channel, callOptions);
        }
      };
    return SubscriptionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubscriptionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceFutureStub>() {
        @java.lang.Override
        public SubscriptionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriptionServiceFutureStub(channel, callOptions);
        }
      };
    return SubscriptionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.nbt.proto.subscription.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.subscription.Subscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    default void unsubscribe(com.nbt.proto.subscription.UnsubscribeRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.subscription.Subscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnsubscribeMethod(), responseObserver);
    }

    /**
     */
    default void getUserSubscriptions(com.nbt.proto.subscription.GetUserSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.subscription.GetUserSubscriptionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserSubscriptionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SubscriptionService.
   */
  public static abstract class SubscriptionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SubscriptionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SubscriptionService.
   */
  public static final class SubscriptionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SubscriptionServiceStub> {
    private SubscriptionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionServiceStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.nbt.proto.subscription.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.subscription.Subscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(com.nbt.proto.subscription.UnsubscribeRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.subscription.Subscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserSubscriptions(com.nbt.proto.subscription.GetUserSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.subscription.GetUserSubscriptionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserSubscriptionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SubscriptionService.
   */
  public static final class SubscriptionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SubscriptionServiceBlockingStub> {
    private SubscriptionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.nbt.proto.subscription.Subscription subscribe(com.nbt.proto.subscription.SubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nbt.proto.subscription.Subscription unsubscribe(com.nbt.proto.subscription.UnsubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nbt.proto.subscription.GetUserSubscriptionsResponse getUserSubscriptions(com.nbt.proto.subscription.GetUserSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserSubscriptionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SubscriptionService.
   */
  public static final class SubscriptionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SubscriptionServiceFutureStub> {
    private SubscriptionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.subscription.Subscription> subscribe(
        com.nbt.proto.subscription.SubscribeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.subscription.Subscription> unsubscribe(
        com.nbt.proto.subscription.UnsubscribeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.subscription.GetUserSubscriptionsResponse> getUserSubscriptions(
        com.nbt.proto.subscription.GetUserSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserSubscriptionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_UNSUBSCRIBE = 1;
  private static final int METHODID_GET_USER_SUBSCRIPTIONS = 2;

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
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((com.nbt.proto.subscription.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.subscription.Subscription>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((com.nbt.proto.subscription.UnsubscribeRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.subscription.Subscription>) responseObserver);
          break;
        case METHODID_GET_USER_SUBSCRIPTIONS:
          serviceImpl.getUserSubscriptions((com.nbt.proto.subscription.GetUserSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.subscription.GetUserSubscriptionsResponse>) responseObserver);
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
          getSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.subscription.SubscribeRequest,
              com.nbt.proto.subscription.Subscription>(
                service, METHODID_SUBSCRIBE)))
        .addMethod(
          getUnsubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.subscription.UnsubscribeRequest,
              com.nbt.proto.subscription.Subscription>(
                service, METHODID_UNSUBSCRIBE)))
        .addMethod(
          getGetUserSubscriptionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.subscription.GetUserSubscriptionsRequest,
              com.nbt.proto.subscription.GetUserSubscriptionsResponse>(
                service, METHODID_GET_USER_SUBSCRIPTIONS)))
        .build();
  }

  private static abstract class SubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubscriptionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.nbt.proto.subscription.SubscriptionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SubscriptionService");
    }
  }

  private static final class SubscriptionServiceFileDescriptorSupplier
      extends SubscriptionServiceBaseDescriptorSupplier {
    SubscriptionServiceFileDescriptorSupplier() {}
  }

  private static final class SubscriptionServiceMethodDescriptorSupplier
      extends SubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SubscriptionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SubscriptionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubscriptionServiceFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getUnsubscribeMethod())
              .addMethod(getGetUserSubscriptionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
