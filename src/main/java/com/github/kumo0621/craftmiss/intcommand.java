package com.github.kumo0621.craftmiss;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.argument.BooleanArgument;
import net.kunmc.lab.commandlib.argument.IntegerArgument;

/**
 * By registering this, you can use the command below.
 * /config intValue // check intValue's current value.
 * /config intValue <integer> // change intValue's value to <integer>.
 */
public class intcommand extends Command {

    public intcommand() {
        super("config");

        addChildren(new Command("intdown") {
            {
                execute(ctx -> {
                    ctx.sendSuccess("最高値が"+craftmiss.zyougen);
                });

                argument(new IntegerArgument("number"), (number, ctx) -> {
                    craftmiss.zyougen = number;
                    ctx.sendSuccess("最低値を変更しました。 " + craftmiss.zyougen);
                });
            }
        });
        addChildren(new Command("start") {
            {
                execute(ctx -> {
                    ctx.sendSuccess("今は"+craftmiss.set);
                });

                argument(new BooleanArgument("true"), (number, ctx) -> {
                    craftmiss.set = number;
                    ctx.sendSuccess("スタートしました " + craftmiss.set);
                });
            }
        });
        addChildren(new Command("kakuritu") {
            {
                execute(ctx -> {
                    ctx.sendSuccess("確率が"+craftmiss.kakuritu+"になりました。");
                });

                argument(new IntegerArgument("number"), (number, ctx) -> {
                    craftmiss.kakuritu = number;
                    ctx.sendSuccess("確率を変更しました。 " + craftmiss.kakuritu);
                });
            }
        });
    }
}
