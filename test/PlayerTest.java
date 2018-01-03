import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class PlayerTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    Location location = context.mock(Location.class);
    Alien alien = context.mock(Alien.class);

    Human player = new Player(100, 10,
                               location, 5);

    @Test
    public void isAliveAtTheStart() {
        assertThat(player.isAlive(), is(true));
    }

    @Test
    public void canAttackAliens() {
        context.checking(new Expectations() {{
            exactly(1).of(alien).takeDamage(10);
            exactly(1).of(alien).getName();
        }});
        player.interact(alien);
    }

    @Test
    public void takesDamageFromEnemies() {
        int initialHealth = player.getHealth();
        player.takeDamage(10);
        int newHealth = player.getHealth();
        assertThat(initialHealth, greaterThan(newHealth));
    }

    @Test
    public void diesIfDamageIsGreaterThanHealth() {
        player.takeDamage(1000);
        assertThat(player.isAlive(), is(false));
    }
}