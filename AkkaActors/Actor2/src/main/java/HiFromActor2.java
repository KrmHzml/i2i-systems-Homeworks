import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class HiFromActor2 extends AbstractBehavior<HiFromActor1.Greeted> {

    public static Behavior<HiFromActor1.Greeted> create() {
        return Behaviors.setup(HiFromActor2::new);
    }

    private HiFromActor2(ActorContext<HiFromActor1.Greeted> context) {
        super(context);
    }

    @Override
    public Receive<HiFromActor1.Greeted> createReceive() {
        return newReceiveBuilder().onMessage(HiFromActor1.Greeted.class, this::onGreeted).build();
    }

    private Behavior<HiFromActor1.Greeted> onGreeted(HiFromActor1.Greeted message) {
        getContext().getLog().info("Receiver:Hi From Actor2");
        return this;
    }
}
