def bayes_theorem():
    sensitivity = 0.99
    specificity = 0.95
    prevalence = 0.01

    p_disease = prevalence
    p_no_disease = 1-prevalence
    p_pos_given_disease = sensitivity
    p_pos_given_no_disease = 1-specificity

    numerator = p_pos_given_disease * p_disease
    denominator = (p_pos_given_disease * p_disease) + (p_pos_given_no_disease * p_no_disease)

    probablity = numerator / denominator
    print(f"Probability of actually having the disease given a positive test: {probablity:.4f}")

bayes_theorem()