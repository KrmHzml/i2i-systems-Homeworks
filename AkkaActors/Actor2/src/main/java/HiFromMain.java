import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class HiFromMain extends AbstractBehavior<HiFromMain.SayHello> {

    public static class SayHello {
        public final String name;

        public SayHello(String name) {
            this.name = name;
        }
    }

    public static Behavior<SayHello> create() {
        return Behaviors.setup(HiFromMain::new);
    }

    private final ActorRef<HiFromActor1.Greet> greeter;

    private HiFromMain(ActorContext<SayHello> context) {
        super(context);
        greeter = context.spawn(HiFromActor1.create(), "greeter");
    }

    @Override
    public Receive<SayHello> createReceive() {
        return newReceiveBuilder().onMessage(SayHello.class, this::onStart).build();
    }

    private Behavior<SayHello> onStart(SayHello command) {
        ActorRef<HiFromActor1.Greeted> replyTo =
                getContext().spawn(HiFromActor2.create(), "actor2");
        greeter.tell(new HiFromActor1.Greet(command.name, replyTo));
        return this;
    }

    public static void main(String[] args) {
        final ActorSystem<HiFromMain.SayHello> system =
                ActorSystem.create(HiFromMain.create(), "hi");

        system.tell(new HiFromMain.SayHello(""));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        system.terminate();
    }
}
