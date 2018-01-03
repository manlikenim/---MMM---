import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class AlienTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    Location location = context.mock(Location.class);

    Human player = context.mock(Human.class);

    Alien alien = new BadAlien("name", "description",
                             25, 15);

    @Test
    public void isAliveAtTheStart() {
        assertThat(alien.isAlive(), is(true));
    }

    @Test
    public void canAttackPlayer() {
        context.checking(new Expectations() {{
            exactly(1).of(player).takeDamage(15);
        }});
        alien.interact(player);
    }

    @Test
    public void takesDamageFromPlayer() {
        int initialHealth = alien.getHealth();
        alien.takeDamage(10);
        int newHealth = alien.getHealth();
        assertThat(initialHealth, greaterThan(newHealth));
    }

    @Test
    public void diesIfDamageIsGreaterThanHealth() {
        alien.takeDamage(1000);
        assertThat(alien.isAlive(), is(false));
    }
}
