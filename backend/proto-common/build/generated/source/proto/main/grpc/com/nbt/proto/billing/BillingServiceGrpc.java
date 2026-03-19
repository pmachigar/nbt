package com.nbt.proto.billing;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: billing_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BillingServiceGrpc {

  private BillingServiceGrpc() {}

  public static final String SERVICE_NAME = "com.nbt.proto.billing.BillingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.billing.GenerateInvoiceRequest,
      com.nbt.proto.billing.Invoice> getGenerateInvoiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateInvoice",
      requestType = com.nbt.proto.billing.GenerateInvoiceRequest.class,
      responseType = com.nbt.proto.billing.Invoice.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.billing.GenerateInvoiceRequest,
      com.nbt.proto.billing.Invoice> getGenerateInvoiceMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.billing.GenerateInvoiceRequest, com.nbt.proto.billing.Invoice> getGenerateInvoiceMethod;
    if ((getGenerateInvoiceMethod = BillingServiceGrpc.getGenerateInvoiceMethod) == null) {
      synchronized (BillingServiceGrpc.class) {
        if ((getGenerateInvoiceMethod = BillingServiceGrpc.getGenerateInvoiceMethod) == null) {
          BillingServiceGrpc.getGenerateInvoiceMethod = getGenerateInvoiceMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.billing.GenerateInvoiceRequest, com.nbt.proto.billing.Invoice>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateInvoice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.billing.GenerateInvoiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.billing.Invoice.getDefaultInstance()))
              .setSchemaDescriptor(new BillingServiceMethodDescriptorSupplier("GenerateInvoice"))
              .build();
        }
      }
    }
    return getGenerateInvoiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nbt.proto.billing.GetInvoicesRequest,
      com.nbt.proto.billing.GetInvoicesResponse> getGetInvoicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInvoices",
      requestType = com.nbt.proto.billing.GetInvoicesRequest.class,
      responseType = com.nbt.proto.billing.GetInvoicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nbt.proto.billing.GetInvoicesRequest,
      com.nbt.proto.billing.GetInvoicesResponse> getGetInvoicesMethod() {
    io.grpc.MethodDescriptor<com.nbt.proto.billing.GetInvoicesRequest, com.nbt.proto.billing.GetInvoicesResponse> getGetInvoicesMethod;
    if ((getGetInvoicesMethod = BillingServiceGrpc.getGetInvoicesMethod) == null) {
      synchronized (BillingServiceGrpc.class) {
        if ((getGetInvoicesMethod = BillingServiceGrpc.getGetInvoicesMethod) == null) {
          BillingServiceGrpc.getGetInvoicesMethod = getGetInvoicesMethod =
              io.grpc.MethodDescriptor.<com.nbt.proto.billing.GetInvoicesRequest, com.nbt.proto.billing.GetInvoicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInvoices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.billing.GetInvoicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nbt.proto.billing.GetInvoicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BillingServiceMethodDescriptorSupplier("GetInvoices"))
              .build();
        }
      }
    }
    return getGetInvoicesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BillingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillingServiceStub>() {
        @java.lang.Override
        public BillingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillingServiceStub(channel, callOptions);
        }
      };
    return BillingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BillingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillingServiceBlockingStub>() {
        @java.lang.Override
        public BillingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillingServiceBlockingStub(channel, callOptions);
        }
      };
    return BillingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BillingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BillingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BillingServiceFutureStub>() {
        @java.lang.Override
        public BillingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BillingServiceFutureStub(channel, callOptions);
        }
      };
    return BillingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void generateInvoice(com.nbt.proto.billing.GenerateInvoiceRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.billing.Invoice> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateInvoiceMethod(), responseObserver);
    }

    /**
     */
    default void getInvoices(com.nbt.proto.billing.GetInvoicesRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.billing.GetInvoicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInvoicesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BillingService.
   */
  public static abstract class BillingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BillingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BillingService.
   */
  public static final class BillingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BillingServiceStub> {
    private BillingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillingServiceStub(channel, callOptions);
    }

    /**
     */
    public void generateInvoice(com.nbt.proto.billing.GenerateInvoiceRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.billing.Invoice> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateInvoiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getInvoices(com.nbt.proto.billing.GetInvoicesRequest request,
        io.grpc.stub.StreamObserver<com.nbt.proto.billing.GetInvoicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInvoicesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BillingService.
   */
  public static final class BillingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BillingServiceBlockingStub> {
    private BillingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.nbt.proto.billing.Invoice generateInvoice(com.nbt.proto.billing.GenerateInvoiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateInvoiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nbt.proto.billing.GetInvoicesResponse getInvoices(com.nbt.proto.billing.GetInvoicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInvoicesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BillingService.
   */
  public static final class BillingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BillingServiceFutureStub> {
    private BillingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BillingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BillingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.billing.Invoice> generateInvoice(
        com.nbt.proto.billing.GenerateInvoiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateInvoiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nbt.proto.billing.GetInvoicesResponse> getInvoices(
        com.nbt.proto.billing.GetInvoicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInvoicesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_INVOICE = 0;
  private static final int METHODID_GET_INVOICES = 1;

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
        case METHODID_GENERATE_INVOICE:
          serviceImpl.generateInvoice((com.nbt.proto.billing.GenerateInvoiceRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.billing.Invoice>) responseObserver);
          break;
        case METHODID_GET_INVOICES:
          serviceImpl.getInvoices((com.nbt.proto.billing.GetInvoicesRequest) request,
              (io.grpc.stub.StreamObserver<com.nbt.proto.billing.GetInvoicesResponse>) responseObserver);
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
          getGenerateInvoiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.billing.GenerateInvoiceRequest,
              com.nbt.proto.billing.Invoice>(
                service, METHODID_GENERATE_INVOICE)))
        .addMethod(
          getGetInvoicesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.nbt.proto.billing.GetInvoicesRequest,
              com.nbt.proto.billing.GetInvoicesResponse>(
                service, METHODID_GET_INVOICES)))
        .build();
  }

  private static abstract class BillingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BillingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.nbt.proto.billing.BillingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BillingService");
    }
  }

  private static final class BillingServiceFileDescriptorSupplier
      extends BillingServiceBaseDescriptorSupplier {
    BillingServiceFileDescriptorSupplier() {}
  }

  private static final class BillingServiceMethodDescriptorSupplier
      extends BillingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BillingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BillingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BillingServiceFileDescriptorSupplier())
              .addMethod(getGenerateInvoiceMethod())
              .addMethod(getGetInvoicesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
