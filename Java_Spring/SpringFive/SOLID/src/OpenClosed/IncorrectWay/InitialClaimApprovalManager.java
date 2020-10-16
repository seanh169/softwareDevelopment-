package OpenClosed.IncorrectWay;



    public class InitialClaimApprovalManager {
        public void processHealthClaim (HealthInsuranceSurveyor surveyor)    {
            if(surveyor.isValidClaim()){
                System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
            }
        }
    }

