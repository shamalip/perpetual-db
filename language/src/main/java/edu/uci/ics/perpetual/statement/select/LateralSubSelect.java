
package edu.uci.ics.perpetual.statement.select;

import edu.uci.ics.perpetual.expression.Alias;

/**
 * A lateral subselect followed by an alias.
 *
 * @author Tobias Warneke
 */
public class LateralSubSelect implements FromItem {

    private SubSelect subSelect;
    private Alias alias;
    private Pivot pivot;

    public void setSubSelect(SubSelect subSelect) {
        this.subSelect = subSelect;
    }

    public SubSelect getSubSelect() {
        return subSelect;
    }

    @Override
    public void accept(FromItemVisitor fromItemVisitor) {
        fromItemVisitor.visit(this);
    }

    @Override
    public Alias getAlias() {
        return alias;
    }

    @Override
    public void setAlias(Alias alias) {
        this.alias = alias;
    }

    @Override
    public Pivot getPivot() {
        return pivot;
    }

    @Override
    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    @Override
    public String toString() {
        return "LATERAL" + subSelect.toString()
                + ((alias != null) ? alias.toString() : "")
                + ((pivot != null) ? " " + pivot : "");
    }
}
