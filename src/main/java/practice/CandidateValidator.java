package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int VALID_PERIOD = 10;
    private static final String NATIONALITY_UA = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UA)
                && isPeriodValid(candidate);
    }

    private boolean isPeriodValid(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= VALID_PERIOD;
    }
}
