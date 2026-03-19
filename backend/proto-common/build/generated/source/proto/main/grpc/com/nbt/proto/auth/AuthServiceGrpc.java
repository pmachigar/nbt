package com.nbt.proto.auth;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: auth_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthServiceGrpc {

  private AuthServiceGrpc() {}

  public static final String SERVICE_NAME = "com.nbt.proto.auth.AuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.auth.LoginRequest,
      com.nbt.proto.auth.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = com.nbt.proto.auth.LoginRequest.class,
      responseType = com.nbt.proto.auth.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.auth.LoginRequest,
      com.nbt.proto.auth.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.auth.LoginRequest, com.nbt.proto.auth.LoginResponse> getLoginMethod;
    if ((getLoginMethod = AuthServiceGrpc.getLoginMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getLoginMethod = AuthServiceGrpc.getLoginMethod) == null) {
          AuthServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.auth.LoginRequest, com.nbt.proto.auth.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.auth.ValidateTokenRequest,
      com.nbt.proto.auth.ValidateTokenResponse> getValidateTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateToken",
      requestType = com.nbt.proto.auth.ValidateTokenRequest.class,
      responseType = com.nbt.proto.auth.ValidateTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.auth.ValidateTokenRequest,
      com.nbt.proto.auth.ValidateTokenResponse> getValidateTokenMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.auth.ValidateTokenRequest, com.nbt.proto.auth.ValidateTokenResponse> getValidateTokenMethod;
    if ((getValidateTokenMethod = AuthServiceGrpc.getValidateTokenMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getValidateTokenMethod = AuthServiceGrpc.getValidateTokenMethod) == null) {
          AuthServiceGrpc.getValidateTokenMethod = getValidateTokenMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.auth.ValidateTokenRequest, com.nbt.proto.auth.ValidateTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.ValidateTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.ValidateTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("ValidateToken"))
              .build();
        }
      }
    }
    return getValidateTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.auth.TwoFactorRequest,
      com.nbt.proto.auth.TwoFactorResponse> getRequestTwoFactorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestTwoFactor",
      requestType = com.nbt.proto.auth.TwoFactorRequest.class,
      responseType = com.nbt.proto.auth.TwoFactorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.auth.TwoFactorRequest,
      com.nbt.proto.auth.TwoFactorResponse> getRequestTwoFactorMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.auth.TwoFactorRequest, com.nbt.proto.auth.TwoFactorResponse> getRequestTwoFactorMethod;
    if ((getRequestTwoFactorMethod = AuthServiceGrpc.getRequestTwoFactorMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getRequestTwoFactorMethod = AuthServiceGrpc.getRequestTwoFactorMethod) == null) {
          AuthServiceGrpc.getRequestTwoFactorMethod = getRequestTwoFactorMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.auth.TwoFactorRequest, com.nbt.proto.auth.TwoFactorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestTwoFactor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.TwoFactorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.TwoFactorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("RequestTwoFactor"))
              .build();
        }
      }
    }
    return getRequestTwoFactorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.auth.VerifyTwoFactorRequest,
      com.nbt.proto.auth.LoginResponse> getVerifyTwoFactorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyTwoFactor",
      requestType = com.nbt.proto.auth.VerifyTwoFactorRequest.class,
      responseType = com.nbt.proto.auth.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.auth.VerifyTwoFactorRequest,
      com.nbt.proto.auth.LoginResponse> getVerifyTwoFactorMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.auth.VerifyTwoFactorRequest, com.nbt.proto.auth.LoginResponse> getVerifyTwoFactorMethod;
    if ((getVerifyTwoFactorMethod = AuthServiceGrpc.getVerifyTwoFactorMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getVerifyTwoFactorMethod = AuthServiceGrpc.getVerifyTwoFactorMethod) == null) {
          AuthServiceGrpc.getVerifyTwoFactorMethod = getVerifyTwoFactorMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.auth.VerifyTwoFactorRequest, com.nbt.proto.auth.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyTwoFactor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.VerifyTwoFactorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.auth.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("VerifyTwoFactor"))
              .build();
        }
      }
    }
    return getVerifyTwoFactorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub>() {
        @java.lang.Override
        public AuthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceStub(channel, callOptions);
        }
      };
    return AuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub>() {
        @java.lang.Override
        public AuthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub>() {
        @java.lang.Override
        public AuthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceFutureStub(channel, callOptions);
        }
      };
    return AuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void login(com.nbt.proto.auth.LoginRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.LoginResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    default void validateToken(com.nbt.proto.auth.ValidateTokenRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.ValidateTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateTokenMethod(), responseObserver);
    }

    /**
     */
    default void requestTwoFactor(com.nbt.proto.auth.TwoFactorRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.TwoFactorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestTwoFactorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns token on success
     * </pre>
     */
    default void verifyTwoFactor(com.nbt.proto.auth.VerifyTwoFactorRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.LoginResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyTwoFactorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuthService.
   */
  public static abstract class AuthServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AuthServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AuthServiceStub> {
    private AuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(com.nbt.proto.auth.LoginRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.LoginResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateToken(com.nbt.proto.auth.ValidateTokenRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.ValidateTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestTwoFactor(com.nbt.proto.auth.TwoFactorRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.TwoFactorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestTwoFactorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns token on success
     * </pre>
     */
    public void verifyTwoFactor(com.nbt.proto.auth.VerifyTwoFactorRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.auth.LoginResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyTwoFactorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthServiceBlockingStub> {
    private AuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.nbt.proto.auth.LoginResponse login(com.nbt.proto.auth.LoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nbt.proto.auth.ValidateTokenResponse validateToken(com.nbt.proto.auth.ValidateTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nbt.proto.auth.TwoFactorResponse requestTwoFactor(com.nbt.proto.auth.TwoFactorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestTwoFactorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns token on success
     * </pre>
     */
    public com.nbt.proto.auth.LoginResponse verifyTwoFactor(com.nbt.proto.auth.VerifyTwoFactorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyTwoFactorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuthService.
   */
  public static final class AuthServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthServiceFutureStub> {
    private AuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.auth.LoginResponse> login(
        com.nbt.proto.auth.LoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.auth.ValidateTokenResponse> validateToken(
        com.nbt.proto.auth.ValidateTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.auth.TwoFactorResponse> requestTwoFactor(
        com.nbt.proto.auth.TwoFactorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestTwoFactorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns token on success
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.auth.LoginResponse> verifyTwoFactor(
        com.nbt.proto.auth.VerifyTwoFactorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyTwoFactorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_VALIDATE_TOKEN = 1;
  private static final int METHODID_REQUEST_TWO_FACTOR = 2;
  private static final int METHODID_VERIFY_TWO_FACTOR = 3;

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
        case METHODID_LOGIN:
          serviceImpl.login((com.nbt.proto.auth.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.auth.LoginResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_TOKEN:
          serviceImpl.validateToken((com.nbt.proto.auth.ValidateTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.auth.ValidateTokenResponse>) responseObserver);
          break;
        case METHODID_REQUEST_TWO_FACTOR:
          serviceImpl.requestTwoFactor((com.nbt.proto.auth.TwoFactorRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.auth.TwoFactorResponse>) responseObserver);
          break;
        case METHODID_VERIFY_TWO_FACTOR:
          serviceImpl.verifyTwoFactor((com.nbt.proto.auth.VerifyTwoFactorRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.auth.LoginResponse>) responseObserver);
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
          getLoginMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.auth.LoginRequest,
              com.nbt.proto.auth.LoginResponse>(
                service, METHODID_LOGIN)))
        .addMethod(
          getValidateTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.auth.ValidateTokenRequest,
              com.nbt.proto.auth.ValidateTokenResponse>(
                service, METHODID_VALIDATE_TOKEN)))
        .addMethod(
          getRequestTwoFactorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.auth.TwoFactorRequest,
              com.nbt.proto.auth.TwoFactorResponse>(
                service, METHODID_REQUEST_TWO_FACTOR)))
        .addMethod(
          getVerifyTwoFactorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.auth.VerifyTwoFactorRequest,
              com.nbt.proto.auth.LoginResponse>(
                service, METHODID_VERIFY_TWO_FACTOR)))
        .build();
  }

  private static abstract class AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.nbt.proto.auth.AuthProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthService");
    }
  }

  private static final class AuthServiceFileDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier {
    AuthServiceFileDescriptorSupplier() {}
  }

  private static final class AuthServiceMethodDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getValidateTokenMethod())
              .addMethod(getRequestTwoFactorMethod())
              .addMethod(getVerifyTwoFactorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
