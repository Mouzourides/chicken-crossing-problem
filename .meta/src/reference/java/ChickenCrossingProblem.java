public class ChickenCrossingProblem implements Crossing {

    @Override
    public void move(Items man, Items item) throws Exception {
        if(validInputs(man,item)){
            if(leftSide.contains(Items.MAN) && !rightSide.contains(item)){
                rightSide.add(item);
                leftSide.remove(item);
                moveMan();
                checkValid();
            }
            else if(rightSide.contains(Items.MAN) && !leftSide.contains(item)){
                leftSide.add(item);
                rightSide.remove(item);
                moveMan();
                checkValid();
            }
            else{
                throw new Exception("Error 005: Invalid move");
            }
        }
        else{
            throw new Exception("Error 004: Invalid parameters");
        }
    }

    @Override
    public void move(Items man) throws Exception {
        if(man == Items.MAN){
            moveMan();
            checkValid();
        }
        else{
            throw new Exception("Error 004: Invalid parameters");
        }
    }

    private boolean validInputs(Items man, Items item){
        return man == Items.MAN && (item == Items.CORN || item == Items.FOX || item == Items.CHICKEN);
    }


    private void moveMan() {
        if(leftSide.contains(Items.MAN)){
            rightSide.add(Items.MAN);
            leftSide.remove(Items.MAN);
        }
        else{
            leftSide.add(Items.MAN);
            rightSide.remove(Items.MAN);
        }
    }


    // Checks if logic is met
    private void checkValid() throws Exception{
        if(leftSide.contains(Items.FOX) && leftSide.contains(Items.CHICKEN) && leftSide.contains(Items.CORN) && !leftSide.contains(Items.MAN))
            throw new Exception("Error 001: CHICKEN will eat CORN and then FOX will eat the CHICKEN");

        else if(rightSide.contains(Items.FOX) && rightSide.contains(Items.CHICKEN) && rightSide.contains(Items.CORN) && !rightSide.contains(Items.MAN))
            throw new Exception("Error 001: CHICKEN will eat CORN and then FOX will eat the CHICKEN");

        else if(leftSide.contains(Items.FOX) && leftSide.contains(Items.CHICKEN) && !leftSide.contains(Items.MAN))
            throw new Exception("Error 002: FOX will eat the CHICKEN");

        else if(leftSide.contains(Items.CHICKEN) && leftSide.contains(Items.CORN) && !leftSide.contains(Items.MAN))
            throw new Exception("Error 003: CHICKEN will eat the CORN");

        else if(rightSide.contains(Items.FOX) && rightSide.contains(Items.CHICKEN) && !rightSide.contains(Items.MAN))
            throw new Exception("Error 002: FOX will eat the CHICKEN");

        else if(rightSide.contains(Items.CHICKEN) && rightSide.contains(Items.CORN) && !rightSide.contains(Items.MAN))
            throw new Exception("Error 003: CHICKEN will eat the CORN");

        else if((rightSide.contains(Items.CHICKEN) && leftSide.contains(Items.CHICKEN))
                || (rightSide.contains(Items.CORN) && leftSide.contains(Items.CORN))
                || (rightSide.contains(Items.FOX) && leftSide.contains(Items.FOX))
                || (rightSide.contains(Items.MAN) && leftSide.contains(Items.MAN)))
            throw new Exception("Error 005: Invalid move");
    }
}
