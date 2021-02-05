import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.awt.Color;
import java.awt.Point;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.w3c.dom.css.Rect;

public class TestCases
{
    public static final double DELTA = 0.00001;

    @Test
    public void PlayerNums(){
        Player player = new Player(PlayerKind.WELL_PAID, 10);
        player.generateNewNums();
        Game lotto = new Game();
        lotto.winningLotNumber();
        System.out.println(lotto.getMatchingNum(player));
        System.out.println(lotto.monetaryGain(player));
    }


}
